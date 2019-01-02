df=read.csv("data1.csv")
x=df$X
y=df$Y
relation=lm(y~x)
a=data.frame(x=5)
res=predict(relation,a)
print(res)
plot(x,y,abline(lm(y~x)))
