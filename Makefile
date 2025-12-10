JAVAC=javac
JAVA=java
SRC=.

.PHONY: help deps compile test clean

help:
	@echo "Make tasks:"
	@echo "  deps    - Download dependencies"
	@echo "  compile - Compile main"
	@echo "  test    - Запустити Main"

deps:
	@echo "No dependencies needed"

compile:
	$(JAVAC) $(SRC)/*.java

test: compile
	$(JAVA) Main

