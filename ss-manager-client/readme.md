https://github.com/shadowsocks/shadowsocks/wiki/Manage-Multiple-Users

Protocol
You can send UDP data to Shadowsocks.

>command[: JSON data]

To add a port:

>add: {"server_port": 8001, "password":"7cd308cc059"}

To remove a port:

>remove: {"server_port": 8001}

To receive a pong:

>ping

Shadowsocks will send back transfer statistics:

> stat: {"8001":11370}