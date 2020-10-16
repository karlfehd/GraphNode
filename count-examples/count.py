'''
Count the number of unique words from the sample input file
ignoring special characters and print the results ordered by count.
'''

import re

with open('input.txt') as f:
    lines = f.read()

words = str.split(lines.lower())
counts = dict()

for word in words:
    cleanWord = re.sub(r'\W+','', word)
    if cleanWord in counts:
        counts[cleanWord] += 1
    else:
        counts[cleanWord] = 1

for k, v in sorted(counts.items(), key=lambda item: item[1]):
    print(f'{k:6s} => {v}')
