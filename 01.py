#!/usr/bin/env python3

input = open("01-input.txt", "r")

inputText = input.read()

elves = [x.split("\n") for x in inputText.split("\n\n") ]

def sumElves(elf):
    return sum([int(weight) for weight in elf])

elfSums = [sumElves(x) for x in elves]

print(max(elfSums))
