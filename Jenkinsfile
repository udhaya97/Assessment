def antVersion = 'Ant_1.10.7'
def tomcatWeb = 'G:\\Downloads\\apache-tomcat-9.0.33\\webapps'
   def tomcatBin = 'G:\\Downloads\\apache-tomcat-9.0.33\\bin'
   def tomcatStatus = ''
pipeline {
    agent any 
    stages {
        stage('Build') {
            steps { withEnv( ["ANT_HOME=${tool antVersion}"] ) {
               echo 'Ant Build'
    sh '$ANT_HOME/bin/ant'
}

   
        }
    }
       stage("test appln")
             {
                steps{
                   withEnv( ["ANT_HOME=${tool antVersion}"] ){
                      echo 'Ant Test'
                sh '$ANT_HOME/bin/ant junit'
                }
                }
                
                
             }
       stage('Test report'){
          steps{
             echo 'Test Report Taking'
               cucumber fileIncludePattern: "**/*.json".sortingMethod:'ALPHABETICAL'
          }
   }
             
             stage("SonarQube Analysis")
             {
                steps{
                   withEnv( ["ANT_HOME=${tool antVersion}"] ){
                      echo 'Sonar Qube Analysis'
                sh '$ANT_HOME/bin/ant sonar'
                }
                }
                
                
             }
             
             
    
       stage('Deploy to Tomcat'){
          steps{
             echo 'Tomcat Deploy'
     bat "copy target\\EmployeeCrudAnt.war \"${tomcatWeb}\\EmployeeCrudAnt.war\""
          }
   }
      stage ('Start Tomcat Server') {
         steps{
         echo 'Tomcat Starts'
         bat "${tomcatBin}\\startup.bat"
        
         }
   }
    }
}
