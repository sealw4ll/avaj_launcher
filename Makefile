all: compile run

compile:
	@find * -name "*.java" ! -name "UnitTest.java" > sources.txt
	@javac @sources.txt 

run:
	@java Main sources.txt scenario.txt

clean:
	-@rm *.class
	-@rm sources.txt
	-@rm simulation.txt

# test:
# 	java -jar junit-platform-console-standalone-1.9.2.jar --class-path . --select-class UnitTest

re: clean compile run