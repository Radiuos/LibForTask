def call(def ZipPath, def SolutionName, def Soln_Config_Name)
{
  def btime = BUILD_TIMESTAMP
  def proj_name = SolutionName.replace(".sln","")
  def archive = """${btime}""".replaceAll(" ", "")
  def file_name = """${proj_name}_${archive}.zip """
  def foulder = """${proj_name}\\bin\\${Soln_Config_Name}"""
  def url = 'http://192.168.0.110:8000'
  
  //NugetTask\bin\Debug
  bat """ ${ZipPath} a -tzip ${file_name} ${foulder} """
  
  
  
  bat """-X PUT --upload-file ${file_name} ${url} """
    
}
