def call(def dotnet, def options = null)
{
  //bat """ nuget restore ${SolutionName}  ${options ?: ''} """
  //nuget restore <projectPath> [options]
  bat """ ${dotnet} restore ${options ?: ''} """
}
