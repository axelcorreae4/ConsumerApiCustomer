<h1>ConsumerApiCustomer</h1>
<h2>Api que consume información de otro legado para proporcionar el acceso a la información</h2>

## EndPoints: 
- FakeApi: https://my.api.mockaroo.com/customer.json?key=54dfba60
- ApiCustomer: http://localhost:8080/api/v1/Customer
- Documentation: http://localhost:8080/swagger-ui/index.html#/

## Documentation 
- Open Api 3.0

## Security
- JWT Version : 3.0

## Consumer Example 
- Search Customer by RFC (Get): http://localhost:8080/api/v1/Customer/MANA2821993TF1
- The API consumer must send the APIKey in the body request

