while True:
    (a, b) = [int(i) for i in input().split(" ")]
    if (a == 0 and b == 0):
        break
    print(str(a // b) + " " + str(a  % b) + " / " + str(b))