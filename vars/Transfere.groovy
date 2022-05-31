def call(def ZipPath, def SolutionName, def Soln_Config_Name, def url)
{
  def btime = BUILD_TIMESTAMP
  def proj_name = SolutionName.replace(".sln","")
  def archive = """${btime}""".replaceAll(" ", "")
  def file_name = """${proj_name}_${archive}.zip """
  def foulder = """${proj_name}\\bin\\${Soln_Config_Name}"""
  
  bat """${ZipPath} a -tzip ${file_name} ${foulder} """
  
  //bat """curl -X PUT --upload-file ${file_name} ${url} """
  powershell """Invoke-WebRequest -Uri ${url} -Method Post -OutFile ${file_name}"""
  
  bat """del ${file_name}"""
}
