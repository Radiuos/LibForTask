def call(def ZipPath, def SolutionName, def Soln_Config_Name)
{
  def btime = BUILD_TIMESTAMP
  def proj_name = SolutionName.replace(".sln","")
  def archive = """${btime}.zip""".replaceAll(" ", "")
  def file_name = """ ${proj_name}_${archive}.zip """
  def foulder = """${proj_name}\\bin\\${Soln_Config_Name}"""
  
  //NugetTask\bin\Debug
  bat """ ${ZipPath} a -tzip ${file_name} ${foulder} """
  
  def remote = [:]
    remote.name = 'test'
    remote.host = '192.168.0.110'
    remote.user = 'user'
    remote.password = '21'
    remote.allowAnyHosts = true
    writeFile file: file_name.replaceAll("\\s","")
    sshPut remote: remote, from: file_name.replaceAll("\\s",""), into: './data/builds/'
    
}
