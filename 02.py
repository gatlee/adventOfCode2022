#!/usr/bin/env python3

from enum import Enum

class RPS(Enum):
    ROCK = 1
    PAPER = 2
    SCISSORS = 3

order = [RPS.ROCK, RPS.PAPER, RPS.SCISSORS]

def charToRPS(char):
    if (char == "A" or char == "X"):
        return RPS.ROCK
    if (char == "B" or char == "Y"):
        return RPS.PAPER
    if (char == "C" or char == "Z"):
        return RPS.SCISSORS

def getLosingMove(enemyMove):
    return order[(order.index(enemyMove) - 1) % 3]

def getWinningMove(enemyMove):
    return order[(order.index(enemyMove) + 1) % 3]

def score(enemy, myThrow):
    total = 0
    total += myThrow.value
    if (getWinningMove(enemy) == myThrow):
        total += 6
    if (enemy == myThrow):
        total += 3
    return total

with open("./02-input.txt", "r") as file:
    total = 0
    for line in file:
        left, right = line.strip().split(" ")
        instscore = score(charToRPS(left), charToRPS(right))
        print(instscore)
        total += instscore

    print(total)
