def call(def ZipPath, def SolutionName, def Soln_Config_Name, def url)
{
  def btime = BUILD_TIMESTAMP
  def proj_name = SolutionName.replace(".sln","")
  def archive = """${btime}""".replaceAll(" ", "")
  def file_name = """${proj_name}_${archive}.zip"""
  def foulder = """${proj_name}\\bin\\${Soln_Config_Name}"""
  
  bat """${ZipPath} a -tzip ${file_name} ${foulder} """
  
  //bat """curl -X PUT --upload-file ${file_name} ${url} """
 
  def script = """
    try 
    {
      \$retr = 3
      do 
      {
        try {
          \$wc = New-Object System.Net.WebClient
          \$resp = \$wc.UploadFile("${url}", 'Post', "${file_name}")
        }catch 
        { 
          if (\$retr -gt 1) 
            {
              \$retr -= 1
              echo \$_.Exception.Message
              echo "Retry..."
              continue
            }
            throw "Upload failed. See log above"
        }break
      } while(\$True)
    } catch 
    {
      echo \$_.Exception.Message
      exit 100
    }"""
  powershell (script)
  bat """del ${file_name}"""
}
