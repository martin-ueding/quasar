# Copyright (c) 2012 Martin Ueding <dev@martin-ueding.de>

java := $(wildcard *.java)
class := $(java:.java=.class)
properties := $(wildcard *.properties)

quasar.jar: manifest.mf $(class) hintergrund.png makefile $(properties)
	jar -cfm $@ $^ *.class

%.class: %.java
	javac $<

.PHONY: clean
clean:
	$(RM) *.class *.jar
	$(RM) *.o *.out
	$(RM) *.pyc *.pyo
	$(RM) *.orig
