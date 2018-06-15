https://docs.microsoft.com/de-de/java/azure/spring-framework/deploy-spring-boot-java-app-on-kubernetes

az group create --name=blissfish-k8 --location=westeurope

az acr create --admin-enabled --resource-group blissfish-k8 --location westeurope --name blissfishregistry --sku Basic