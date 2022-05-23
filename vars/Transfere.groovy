def call(def ZipPath, def SolutionName, def Soln_Config_Name)
{
  def btime= ${BUILD_TIMESTAMP}
  def proj_name = SolutionName.replace(".sln","")
  def foulder = """ ${proj_name}\\bin\\${Soln_Config_Name} """
  //NugetTask\bin\Debug
  bat """ ${ZipPath} a -tzip ${btime}.zip ${foulder} """
}
