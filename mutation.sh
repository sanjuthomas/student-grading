mvn -s settings.xml clean install
mvn -s settings.xml org.pitest:pitest-maven:mutationCoverage
