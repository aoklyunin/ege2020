f = open("27-33b.txt", "r")
n = int(f.readline())
lst = []
for i in range(n):
    lst.append([int(x) for x in f.readline().split(' ')])

res = []
for i in range(n):
    res.append([0, 0, 0, 0])

res[0][(lst[0][0] + lst[0][1]) % 4] = lst[0][0] + lst[0][1]
res[0][(lst[0][1] + lst[0][2]) % 4] = lst[0][1] + lst[0][2]
res[0][(lst[0][2] + lst[0][0]) % 4] = lst[0][2] + lst[0][0]

for i in range(n - 1):
    for j in range(4):
        print(i, j)
        res[i + 1][(res[i][j] + lst[i + 1][0] + lst[i + 1][1]) % 4] = max(
            res[i][j] + lst[i + 1][0] + lst[i + 1][1],
            res[i + 1][(res[i][j] + lst[i + 1][0] + lst[i + 1][1]) % 4]
        )
        res[i + 1][(res[i][j] + lst[i + 1][1] + lst[i + 1][2]) % 4] = max(
            res[i][j] + lst[i + 1][1] + lst[i + 1][2],
            res[i + 1][(res[i][j] + lst[i + 1][1] + lst[i + 1][2]) % 4]
        )
        res[i + 1][(res[i][j] + lst[i + 1][2] + lst[i + 1][0]) % 4] = max(
            res[i][j] + lst[i + 1][2] + lst[i + 1][0],
            res[i + 1][(res[i][j] + lst[i + 1][2] + lst[i + 1][0]) % 4]
        )

print(res[n - 1][0])
