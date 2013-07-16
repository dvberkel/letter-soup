#! /usr/bin/env python

import fileinput

def readPairsFromStdIn():
    pairs = {};
    for line in fileinput.input():
        pair, count = line[0:-1].split(' ')
        pairs[pair] = int(count)
    return pairs

class Tree:
    def __init__(self, letter, pairs):
        self.letter = letter
        self.pairs = pairs
        self.left = None
        self.right = None

    def add(self, letter):
        if (letter == self.letter):
            return
        ab = self.pairs.get(self.letter + letter, 0)
        ba = self.pairs.get(letter + self.letter, 0)
        if (ba - ab > 0):
            self.addToLeft(letter)
        elif (ba - ab < 0):
            self.addToRight(letter)
        else:
            self.addToLeft(letter)

    def addToLeft(self, letter):
        if (self.left != None):
            self.left.add(letter)
        else:
            self.left = Tree(letter, self.pairs)

    def addToRight(self, letter):
        if (self.right != None):
            self.right.add(letter)
        else:
            self.right = Tree(letter, self.pairs)

    def traverse(self, walker):
        if (self.left != None):
            self.left.traverse(walker)
        walker.call(self.letter)
        if (self.right != None):
            self.right.traverse(walker)

class AppendWalker:
    def __init__(self):
        self.result = ""

    def result(self):
        return self.result

    def call(self, letter):
        self.result += letter

if __name__ == '__main__':
    pairs = readPairsFromStdIn()

    tree = Tree("A", pairs)
    for letter in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
        tree.add(letter)

    walker = AppendWalker()
    tree.traverse(walker)

    print(walker.result)
