job('ModelBusExplorer-DiffMerge-Git-2.0') {
    description 'ModelBusExplorer DiffMerge Build.'
    customWorkspace('workspace/ModelBus-Core-2.0-Seed/')
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package pmd:pmd checkstyle:checkstyle")
            properties(skipTest: true)
		rootPOM("TychoBuild/ModelBusExplorer/trunk/org.modelbus.tools.modelbusexplorer.build.master/pom.xml")
        }
                 
    }
    publishers {
    	droneRecorder {
    		serverUrl("http://10.147.66.165:8080")
    		channel("Test.ModelbusExplorer.DiffMerge.Git.2.0")
    		deployKey("5c9a6cb4bfd9a006cd1987d90476f39df904a9c40fe1cc533d4416bab51ba048")
		artifacts("TychoBuild/ModelBusExplorer/trunk/org.modelbus.tools.modelbusexplorer.build.category/target/*zip")
		failsAsUpload(true)

        }
    }
}
