# PostingQuotesAPI
This is an API that fetches some good Quotes spoken by Dr. A.P.J. Abdul Kalam and
and shares on social media like:facebook.com etc. and returns all the information
(User Name,User id,Post Id,Ceation date,Quote posted,Author of that Quote etc.)
as response related to that post in XML format.

This API uses Java SDK for facebook named "restfb-1.41.0" developed by Mark allen.this
provides all the classes for the connection through the facebook and response from facebook.

Every time this API is called through the link "http://localhost:8080/PostingQuotesAPI/webapi/post"
it generates a post to facebook.

Procedure to use this API:
1- Goto developer.facebook.com -> Tools & Support -> Graph API Explorer.
2- On upper dropdown select "Graph API Explorer".
3- On lower dropdown select "Get User Access Token". 
4- This will generate a token as a string just copy it.
5- Goto "PostToFacebook" class and paste this key to the variable "accessToken"(Line number 65).
Enjoy this API!!!!!!!!!!
