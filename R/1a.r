df=read.csv("dat.csv")
df$X=NULL #making one column null
print(mean(df$Y))#optional
print(max(df$Y))#optional
print(min(df$Y))#optional
write.csv(df,"any_name.csv") 

