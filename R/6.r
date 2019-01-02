df=read.csv("dat.csv")
x=df
#kmeans clustering
kc=kmeans(x,2)
plot(x,col=kc$cluster)
points(kc$centers,cex=3)

#hierarchial clustering
d=scale(dist(df,method = "euclidian"))
hc=hclust(dist(d,method = "euclidian"),method="average")
plot(hc)

