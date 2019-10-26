array_len = int(input())
nums_array = [int(i) for i in input().split(" ")]
if (nums_array[0] == 0):
    nums_array[0] = 1
for x in range(1, array_len):
    if (nums_array[x] == 0):
        nums_array[x] = nums_array[x - 1] + 1
    elif nums_array[x] <= nums_array[x - 1]:
        print("NO")
        exit(0)
print("YES")