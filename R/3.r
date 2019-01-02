library(arules)
library(arulesViz)
patterns=random.patterns(nItems=1000)
trans=random.transactions(nItems=1000,nTrans=1000,method="agrawal",patterns=patterns)
rules=apriori(trans,parameter = list(support=0.01,confidence=0.5))
print(inspect(rules))
arulesViz(rules,method="grouped")

