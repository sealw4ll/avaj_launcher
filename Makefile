all: compile run

compile:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt 

run:
	@java Main sources.txt scenario.txt

clean:
	-@rm *.class
	-@rm sources.txt
	-@rm simulation.txt

re: clean compile run