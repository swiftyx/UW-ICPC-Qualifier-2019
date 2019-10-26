(rights, wrongs) = [int(i) for i in input().split(" ")]
rights_array = []
dic = dict()
for x in range(rights):
    i = input()
    l = len(i)
    if not l in dic.keys():
        dic[l] = list()
    dic[l].append(i)
    rights_array.append(i)
for _ in range(wrongs):
    x = input()
    l = len(x)
    if l not in dic.keys():
        print(0)
        continue
    could_be = 0
    for correct in dic.get(l):
        wrongs = 0
        for (a, b) in zip(correct, x):
            if not a == b:
                wrongs += 1
                if wrongs == 2:
                    break
        if wrongs == 1:
            could_be += 1
    print(could_be)
