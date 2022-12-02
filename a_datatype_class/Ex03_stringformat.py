
# -----------------------------------------
#  문자열 포맷
#       0- 문자열 포맷팅
#               print('내가 좋아하는 숫자는 ', 100 )
#       1- format() 이용
#               print('내가 좋아하는 숫자는 {0:d} 이다'.format(100) )
#       2- % 사용
#               print('내가 좋아하는 숫자는 %d 이다' % 100 )
#       성능(속도)는 %이 더 빠르다고는 하지만 코드가 깔끔하게 하는 것이 더 중요하다고 하고는
#       어느 것으로 선택하라고는 안 나옴


# format()이용


# [참고] http://pyformat.info

# % 이용 - printf() 역할
name = '홍길동'
age = 22
height = 170.456

print('이름: {0} / 나이:{1} / 키:{2:.1f}'.format(name, age, height)) #소수점 첫 번째 자리 .1f

print('이름: %s, 나이:%d, 키:%.1f' % (name, age, height))


#--------------------------------------------------
# 실수인 경우


