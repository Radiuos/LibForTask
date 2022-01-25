class New {
    void RunMaven(def mvnHome)
    {
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }
    void Run()
    {
        sh 'mvn exec:java -Dexec.mainClass="main.java.Hello"'
    }
}
