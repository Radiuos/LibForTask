def call(def ZipPath, def SolutionName, def Soln_Config_Name)
{
  def btime = BUILD_TIMESTAMP
  def proj_name = SolutionName.replace(".sln","")
  def archive = """${btime}""".replaceAll(" ", "")
  def file_name = """ ${proj_name}_${archive}.zip """
  def foulder = """${proj_name}\\bin\\${Soln_Config_Name}"""
  
  //NugetTask\bin\Debug
  bat """ ${ZipPath} a -tzip ${file_name} ${foulder} """
  
  def url = 'http://192.168.0.110:9000/'
  def response =  httpRequest(acceptType: 'APPLICATION_JSON', contentType: 'APPLICATION_ZIP',
                         customHeaders  : [[name: "authorization"],[name: 'x-username' , value: 'admin']],
                         httpMode: 'POST', ignoreSslErrors: true, multipartName: 'AppDefenseBundle.zip', timeout: 900,
                         responseHandle: 'NONE', uploadFile: "${file_name}", url: "${url}"
    
}
