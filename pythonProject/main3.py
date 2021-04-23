import time
max = 0
vals = []

def test(pos, size, sum):
    global max
    if pos == size:
        if sum % 4 == 0 and sum > max:
            max = sum
    else:
        test(pos + 1, size, sum + vals[pos][0] + vals[pos][1])
        test(pos + 1, size, sum + vals[pos][0] + vals[pos][2])
        test(pos + 1, size, sum + vals[pos][2] + vals[pos][1])


start = time.time()
with open("27-33a.txt", 'r') as f:
    n = int(f.readline())
    vals = [[int(v) for v in f.readline().split(' ')] for i in range(n)]
    test(0, n, 0)
    print(max)

print(time.time() - start)
