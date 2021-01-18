#ident  "@(#)local.cshrc        2.1     04/01/15 MLH"
#
#
umask 022
set path=(/bin /usr/bin /usr/ucb /etc .)
if ( $?prompt ) then
        set history=32
endif

