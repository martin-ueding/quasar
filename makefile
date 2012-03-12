# Copyright (c) 2012 Martin Ueding <dev@martin-ueding.de>

java := $(wildcard *.java)
class := $(java:.java=.class)

kollisionskurs.jar: manifest.mf $(class) pic makefile
	jar -cfm $@ $^ *.class

%.class: %.java
	javac $<

.PHONY: clean
clean:
	$(RM) *.class *.jar
	$(RM) *.o *.out
	$(RM) *.pyc *.pyo
	$(RM) *.orig
