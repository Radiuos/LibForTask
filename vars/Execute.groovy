def call(def version, def SolutionName, def task, def Soln_Config_Name, def projname = null, def project_config = null, def Output_Filename = null)
{
  //projname = projname ?: ''
  //project_config = project_config ?: ''
  //Output_Filename = Output_Filename ?: ''
  def vswhere_path = bat(script: """@"\\Program Files (x86)\\Microsoft Visual Studio\\Installer\\vswhere.exe" -version ${version} -property installationPath""", returnStdout: true)
  def componate_path = '"'+vswhere_path+"\\Common7\\IDE\\devenv.com"+'"'
  def devenv_path = componate_path.replaceAll("\\r|\\n", "")
  bat """ ${devenv_path} ${SolutionName} /${task} ${Soln_Config_Name} ${projname ?: ''} ${project_config ?: ''} ${Output_Filename ?: ''} """
}
