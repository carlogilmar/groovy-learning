import groovy.transform.builder.Builder

@Builder
class Message {
    String from, to, subject, body
}

def message = Message
        .builder()  // New internal helper class.
        .from('mrhaki@mrhaki.com')  // Method per property.
        .to('mail@host.nl')
        .subject('Sample mail')
        .body('Groovy rocks!')
        .build()  // Create instance of Message

assert message.body == 'Groovy rocks!'
assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Sample mail'
assert message.to == 'mail@host.nl'

@Builder(builderMethodName = 'initiator', buildMethodName = 'create')
class Message2 {
    String from, to, subject, body
}

def message2 = Message2.initiator()
        .from('mrhaki@mrhaki.com')
        .body('Groovy rocks!')
        .create()

assert message2.body == 'Groovy rocks!'
assert message2.from == 'mrhaki@mrhaki.com'
