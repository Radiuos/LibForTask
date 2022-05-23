def call(def ZipPath, def SolutionName, def Soln_Config_Name)
{
  btime=${BUILD_TIMESTAMP}
  proj_name = SolutionName.replace(".sln","")
  foulder = """ ${proj_name}\\bin\\${Soln_Config_Name} """
  //NugetTask\bin\Debug
  bat """ ${ZipPath} a -tzip ${btime}.zip ${foulder} """
}
