#! /usr/bin/env perl

use strict;
use warnings;

my %pairs = ();

while (my $word = <>) {
    chomp($word);
    my %local_pairs = ();
    for (my $i = 0; $i < length($word) - 1; $i++) {
	my $first = substr $word, $i, 1;
	for (my $j = $i + 1; $j < length($word); $j++) {
	    my $second = substr $word, $j, 1;
	    my $pair = $first . $second;
	    my $count = $local_pairs{$pair} || 0;
	    $local_pairs{$pair} = $count + 1;
	}
    }
    for(keys %local_pairs) {
	my $count = $pairs{$_} || 0;
	$pairs{$_} = $count + 1;
    }
}

for (sort keys %pairs) {
    my $count = $pairs{$_};
    print "$_ $count\n";
}
