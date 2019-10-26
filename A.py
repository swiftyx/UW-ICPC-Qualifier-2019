nums =[int(i) for i in input().split(" ")]
len = nums[0]
least_buy = nums[1]
pretties = [int(i) for i in input().split(" ")]

max_pretty = sum(pretties)
current_len = len

for starting_point in range(len - least_buy):
    base = sum(pretties[starting_point:starting_point+least_buy])
    max_pretty = max(max_pretty, base)
    for num in pretties[starting_point+least_buy:]:
        base += num
        max_pretty = max(max_pretty, base)
# for x in range(len - least_buy):
#     print(sum(pretties[x:]))

    # for z in range (least_buy, current_len):
    #     array = []
    #     for y in range(z):
    #         array.append(pretties[x + y])
    #     if sum(array) > max_pretty:
    #         max_pretty = sum(array)
    # current_len -= 1
    # print(max_pretty)
print(max_pretty)