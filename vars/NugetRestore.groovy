def call(def SolutionName, def options = null)
{
  bat """ nuget restore ${SolutionName}  ${options ?: ''} """
  //nuget restore <projectPath> [options]
}
