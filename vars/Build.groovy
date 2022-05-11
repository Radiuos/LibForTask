def call(def VS_version, def proj_name)
{
  bat  """ "C:\\Program Files\\Microsoft Visual Studio\\${VS_version}\\Community\\Common7\\IDE\\devenv.com" ${proj_name}.sln /build "Debug" """
}
