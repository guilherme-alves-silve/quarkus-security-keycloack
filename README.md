# quarkus-security-keycloack project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-security-keycloack-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-security-keycloack-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/quarkus-security-keycloack-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Start docker for keycloak
```
docker run --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8080 jboss/keycloak
```
Or
```
docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -e KEYCLOAK_IMPORT=/tmp/keycloack-realm-export.json -v ./keycloack-realm-export.json:/tmp/keycloack-realm-export.json jboss/keycloak
```

## To use keycloack, you need to create the realm (or start docker importing the file "keycloack-realm-export.json", show above) follow the link below:

https://www.keycloak.org/docs/latest/server_admin/index.html#_create-realm

Or the tutorial

- You access in your browser the link http://localhost:8180
- Go to "Administration Console" and login with admin user and admin password
- Create the quarkus realm (it's show below "Master" label when you position your mouse above this label)
- Click in "Add realm", create the realm "quarkus-security"
- Go to "Configure" -> "Clients" menu, click in "Create" button, create the client with name quarkus-security-service using "openid-connect".
- Go to "Configure" -> "Roles" menu, click in "Add Role" button, add the role "admin" and "user".
- Go to "Manage" -> "Users" menu, click in "Add user" button, add the user "admin".
- In "Manage" -> "Users" -> "admin", click in "Credentials" button, and add the password "admin" and disable the "Temporary" check box, click "Set password".
- In "Manage" -> "Users" -> "admin", click in "Role Mappings" button, and after that, select "admin" and "user", next, click the button "Add selected".
- Go to "Manage" -> "Users" menu, click in "Add user" button, add the user "user".
- In "Manage" -> "Users" -> "user", click in "Credentials" button, and add the password "user" and disable the "Temporary" check box, click "Set password".
- In "Manage" -> "Users" -> "user", click in "Role Mappings" button, and after that, select "user" and click the button "Add selected".
