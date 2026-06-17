# Enterprise IAM Platform

[![CI](https://github.com/koketseraphasha/enterprise-iam-platform/actions/workflows/ci.yml/badge.svg)](https://github.com/koketseraphasha/enterprise-iam-platform/actions/workflows/ci.yml)

Enterprise Identity and Access Management platform. SSO simulation, MFA, RBAC, user provisioning, access reviews, and audit logs.

## Features
- Single Sign-On simulation
- Multi-Factor Authentication
- Role-Based Access Control
- User provisioning and de-provisioning
- Access reviews and certifications
- Comprehensive audit logging

## Stack
Java 21, Spring Boot, Spring Security, PostgreSQL, Docker

## Quick Start
```bash
docker compose up -d
```

## Deployment & Architecture

This project is designed with cloud-ready principles:

- **Containerized** using Docker for consistent deployment
- **Environment-based configuration** — no hardcoded secrets
- **Modular structure** for independent scaling
- **Stateless design** where applicable
- **Separation of concerns** for maintainability

### Run Locally

`ash
docker-compose up --build
`

---

*Part of the Kirov Dynamics Technology portfolio — backend engineering focused on security, scalability, and system design.*
