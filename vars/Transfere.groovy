def call(def ZipPath, def SolutionName, def Soln_Config_Name)
{
  def btime = BUILD_TIMESTAMP
  def proj_name = SolutionName.replace(".sln","")
  def archive = """${btime}.zip""".replaceAll(" ", "")
  def foulder = """${proj_name}\\bin\\${Soln_Config_Name}"""
  //NugetTask\bin\Debug
  bat """ ${ZipPath} a -tzip ${proj_name}_${archive} ${foulder} """
  
  def remote = [:]
    //remote.name = 'test'
    remote.host = '192.168.0.110'
    remote.user = 'user'
    remote.password = '21'
    remote.allowAnyHosts = true
    writeFile file: """ ${proj_name}_${archive} """
    sshPut remote: remote, from: """ ${proj_name}_${archive} """, into: './data/builds/' 
}
