/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Gant script that creates a functional test
 * 
 * @author Marc Palmer
 */
 

import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU

includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")

target ('default': "Creates a new Grails functional test.") {
	depends( checkVersion, parseArguments, createFunctionalTest )
}                            

target (createFunctionalTest: "Implementation of create-functional-test") {
    def superClass = "functionaltestplugin.FunctionalTestCase"
	createArtifact(name: argsMap["params"][0], suffix: "FunctionalTests", type: "FunctionalTest", path: "test/functional", superClass: superClass)
}
