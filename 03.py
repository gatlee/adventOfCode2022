#!/usr/bin/env python3

def value_letter(x):
    xInt = ord(x)
    if(xInt > 96):
        return xInt - 96
    else:
        return xInt - 64 + 26


## Part 1
# with open("./03-input.txt", "r") as f:
#     total = 0
#     for line in f:
#         length = len(line)
#         leftSet = set(line[:length//2])
#         rightSet = set(line[length//2:])

#         common = leftSet.intersection(rightSet).pop()
#         total += value_letter(common)
#     print(total)
x = []

with open("./03-input.txt", "r") as f:
    total = 0
    bags : list[set[str]]= []
    for line in f:
        if len(bags) == 3:
            x = bags
            badge = bags[0].intersection(bags[1]).intersection(bags[2]).pop()
            total += value_letter(badge)
            lists = []
        else:
            bags.append(set(line.strip()))

    print(total)
