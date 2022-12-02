#!/usr/bin/env python3

from enum import Enum

class RPS(Enum):
    ROCK = 1
    PAPER = 2
    SCISSORS = 3

order = [RPS.ROCK, RPS.PAPER, RPS.SCISSORS]

def charToRPS(char):
    if (char == "A"):
        return RPS.ROCK
    if (char == "B"):
        return RPS.PAPER
    if (char == "C"):
        return RPS.SCISSORS

def getLosingMove(enemyMove):
    return order[(order.index(enemyMove) - 1) % 3]

def getWinningMove(enemyMove):
    return order[(order.index(enemyMove) + 1) % 3]

def getMyMove(enemy, instruction):
    if (instruction == "X"):
        return getLosingMove(enemy)
    if (instruction == "Y"):
        return enemy
    if (instruction == "Z"):
        return getWinningMove(enemy)

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
        left, instruction = line.strip().split(" ")
        enemyMove = charToRPS(left)
        instscore = score(enemyMove, getMyMove(enemyMove, instruction))
        print(instscore)
        total += instscore

    print(total)
