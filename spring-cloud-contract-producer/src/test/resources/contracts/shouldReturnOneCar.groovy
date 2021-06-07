package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Should return one car'

    request {
        method GET()
        url '/cars/1'
    }
    response {
        status OK()
        body '''\
            
                {
                    "id": 1,
                    "color": "yellow",
                    "model": "Mustang",
                    "brand": "Ford"
              }
            
        '''
        headers {
            contentType('application/json')
        }
    }
}