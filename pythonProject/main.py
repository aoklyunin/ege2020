import re

f = open("24-s1.txt", "r")
regexp = re.compile(r'A.R')
print(sum(1 if regexp.search(s) else 0 for s in f))
f.close()
