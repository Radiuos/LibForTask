def call(def version, def SolutionName, def task, Soln_Config_Name = Soln_Config_Name ?: '', def projname, def project_config, def Output_Filename)
{
  def vswhere_path = bat(script: """@"\\Program Files (x86)\\Microsoft Visual Studio\\Installer\\vswhere.exe" -version ${version} -property installationPath""", returnStdout: true)
  def componate_path = '"'+vswhere_path+"\\Common7\\IDE\\devenv.com"+'"'
  def devenv_path = componate_path.replaceAll("\\r|\\n", "")
  bat """ ${devenv_path} ${SolutionName} /${task} ${Soln_Config_Name} ${projname} ${project_config} ${Output_Filename}"""
}
