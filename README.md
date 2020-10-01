# Aggregateservice

A data aggregation microservice template developed using a reactive stack (WebFlux, WebClient, no database support), containing a Helm diagram and ready to deploy to Kubernetes according to common GitOps practices (Argo CD, GitHub Actions, GitHub Container Registry).

Reactive stack:
-
- Spring Reactive Web (WebFlux)
- Reactive WebClient

Microservice contains:
-
- Dockerfile
- GitHub Actions
- GitHub Container Registry
- Helm chart
- Distributed trace support (Jaeger)
- Spring security
- Actuator
- Swagger
