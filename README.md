## How to run test

#### 1. Create a new project on Google Cloud Platform
https://console.cloud.google.com/apis/dashboard?project

#### 2. Create OAuth 2.0 Client credentials
https://console.cloud.google.com/apis/credentials

   - Application Type (Web application)
   - Authorized redirect URI (If you are going to use my Postman collection, https://localhost:8080 )
   
#### 3. Import to Postman collection from project or create your own
#### 4. Look documentation to check how to set up app and generate access and refresh token
https://developers.google.com/identity/protocols/oauth2/web-server#httprest_1

#### 5. Look Gmail APIs documentation 
https://developers.google.com/gmail/apis/reference/rest

#### 6. Fill in your credentials in configuration.properties
#### 7. Provide message recipient email in @BeforeMethod in GmailAPITest class