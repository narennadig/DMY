df=read.csv("data1.csv")
print(df)
x=df$X #assigning variables to columns
y=df$Y
z=df$Z
plot(x,y) 
plot(density(x))
hist(x)
pie(table(z))
